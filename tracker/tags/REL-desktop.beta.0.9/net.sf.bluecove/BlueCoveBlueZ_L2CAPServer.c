/**
 * BlueCove BlueZ module - Java library for Bluetooth on Linux
 *  Copyright (C) 2008 Mina Shokry
 *  Copyright (C) 2008 Vlad Skarzhevskyy
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @version $Id: BlueCoveBlueZ_L2CAPServer.c 1721 2008-01-31 01:12:08Z skarzhevskyy $
 */
#define CPP__FILE "BlueCoveBlueZ_L2CAPServer.c"

#include "BlueCoveBlueZ.h"
#include <bluetooth/l2cap.h>

JNIEXPORT jlong JNICALL Java_com_intel_bluetooth_BluetoothStackBlueZ_l2ServerOpenImpl
  (JNIEnv* env, jobject peer, jlong localDeviceBTAddress, jboolean authorize, jboolean authenticate, jboolean encrypt, jboolean master, jboolean timeouts, jint backlog, jint receiveMTU, jint transmitMTU) {

    // allocate socket
    int handle = socket(AF_BLUETOOTH, SOCK_SEQPACKET, BTPROTO_L2CAP);
    if (handle < 0) {
        throwIOException(env, "Failed to create socket. [%d] %s", errno, strerror(errno));
        return 0;
    }

    struct sockaddr_l2 localAddr;
    //bind local address
    localAddr.l2_family = AF_BLUETOOTH;
    localAddr.l2_psm = 0;
    //bacpy(&localAddr.l2_bdaddr, BDADDR_ANY);
    longToDeviceAddr(localDeviceBTAddress, &localAddr.l2_bdaddr);

    if (bind(handle, (struct sockaddr *)&localAddr, sizeof(localAddr)) < 0) {
        throwIOException(env, "Failed to bind socket. [%d] %s", errno, strerror(errno));
        close(handle);
        return 0;
    }

    // Set link mtu and security options
    struct l2cap_options opt;
    socklen_t opt_len = sizeof(opt);
    memset(&opt, 0, opt_len);
    opt.imtu = receiveMTU;
    opt.omtu = (transmitMTU > 0)?transmitMTU:L2CAP_DEFAULT_MTU;
    opt.flush_to = L2CAP_DEFAULT_FLUSH_TO;
    Edebug("L2CAP set imtu %i, omtu %i", opt.imtu, opt.omtu);

    if (setsockopt(handle, SOL_L2CAP, L2CAP_OPTIONS, &opt, opt_len) < 0) {
        throwIOException(env, "Failed to set L2CAP mtu options. [%d] %s", errno, strerror(errno));
        close(handle);
        return 0;
    }

    // Set link security options
    if (encrypt || authenticate || authorize || master) {
		int socket_opt = 0;
		socklen_t len = sizeof(socket_opt);
        if (getsockopt(handle, SOL_L2CAP, L2CAP_OPTIONS, &socket_opt, &len) < 0) {
            throwIOException(env, "Failed to read L2CAP server mode. [%d] %s", errno, strerror(errno));
            close(handle);
            return 0;
        }
		if (master) {
			socket_opt |= L2CAP_LM_MASTER;
		}
		if (authenticate) {
			socket_opt |= L2CAP_LM_AUTH;
			debug("L2CAP set authenticate");
		}
		if (encrypt) {
			socket_opt |= L2CAP_LM_ENCRYPT;
		}
		if (authorize) {
			socket_opt |= L2CAP_LM_SECURE;
		}

		if ((socket_opt != 0) && setsockopt(handle, SOL_L2CAP, L2CAP_OPTIONS, &socket_opt, sizeof(socket_opt)) < 0) {
			throwIOException(env, "Failed to set L2CAP server mode. [%d] %s", errno, strerror(errno));
            close(handle);
            return 0;
		}
    }

    // put socket into listening mode
    if (listen(handle, backlog) < 0) {
        throwIOException(env, "Failed to listen for L2CAP connections. [%d] %s", errno, strerror(errno));
        close(handle);
        return 0;
    }

    return handle;
}

JNIEXPORT jint JNICALL Java_com_intel_bluetooth_BluetoothStackBlueZ_l2ServerGetPSMImpl
  (JNIEnv* env, jobject peer, jlong handle) {
    struct sockaddr_l2 localAddr;
    socklen_t len = sizeof(localAddr);
    if (getsockname(handle, (struct sockaddr*)&localAddr, &len) < 0) {
        throwIOException(env, "Failed to get l2_psm. [%d] %s", errno, strerror(errno));
		return -1;
	}
	return localAddr.l2_psm;
}


JNIEXPORT void JNICALL Java_com_intel_bluetooth_BluetoothStackBlueZ_l2ServerCloseImpl
  (JNIEnv* env, jobject peer, jlong handle, jboolean quietly) {
    debug("RFCOMM close server handle %li", handle);
    // Closing channel, further sends and receives will be disallowed.
    if (shutdown(handle, SHUT_RDWR) < 0) {
        debug("server shutdown failed. [%d] %s", errno, strerror(errno));
    }
    if (close(handle) < 0) {
        if (quietly) {
            debug("Failed to close server socket. [%d] %s", errno, strerror(errno));
        } else {
            throwIOException(env, "Failed to close server socket. [%d] %s", errno, strerror(errno));
        }
    }
}

JNIEXPORT jlong JNICALL Java_com_intel_bluetooth_BluetoothStackBlueZ_l2ServerAcceptAndOpenServerConnection
  (JNIEnv* env, jobject peer, jlong handle) {
    struct sockaddr_l2 remoteAddr;
	socklen_t  remoteAddrLen = sizeof(remoteAddr);
	int client_socket = accept(handle, (struct sockaddr*)&remoteAddr, &remoteAddrLen);
	if (client_socket < 0) {
	    throwIOException(env, "Failed to accept L2CAP client connection. [%d] %s", errno, strerror(errno));
	    return 0;
	}
	return client_socket;
}
