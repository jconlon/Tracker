#!/bin/sh -e

# images.sh script is based on the images.sh script from the debian-live project.
# /usr/share/live-helper/examples/cron/images.sh is a script used to
# build the official prebuild images, it builds iso, usb-hdd and net
# images after each other without problems.

# this script uses similar techniques to build a set of images for the tracker irouter project.

# Static variables

# iRouter version
VERSION="0.1.1"

# Name of the distribution.  This variable is used differently than the original script.
# It is used initially just for naming the final artifacts. 
# Note: Lenny the default debian release will be used for the distribution.
# DISTRIBUTIONS="${DISTRIBUTIONS:-etch lenny sid}"
DISTRIBUTIONS="${DISTRIBUTIONS:-irouter}"

# Use the standard Flavour of Debian.
# FLAVOURS="${FLAVOURS:-standard rescue gnome-desktop kde-desktop lxde-desktop xfce-desktop}"
FLAVOURS="${FLAVOURS:-standard}"
#SOURCE="${SOURCE:-enabled}"
SOURCE="${SOURCE:-disabled}"

# Parent directory of the directories to include in the config of the distros
IROUTERINCLUDES="/home/jconlon/Workspaces/tracker_dev-01/com.verticon.tracker.irouter.distro/config-includes"
IROUTERBUILD="/home/jconlon/Workspaces/tracker_dev-01/com.verticon.tracker.irouter.distro/build"


MIRROR="${MIRROR:-http://mirror/ftp.debian.org/debian/}"
MIRROR_SECURITY="${MIRROR_SECURITY:-http://mirror/ftp.debian.org/debian-security/}"

# Dynamic variables
ARCHITECTURE="$(dpkg --print-architecture)"
DATE="$(date +%Y%m%d)"

cd ${IROUTERBUILD}

for DISTRIBUTION in ${DISTRIBUTIONS}
do
	rm -rf cache/stages*

	for FLAVOUR in ${FLAVOURS}
	do
		mkdir -p config

		if [ -e .stage ]
		then
			lh clean
		fi

		rm -rf config
		rm -rf cache/packages*
		rm -rf cache/stages_rootfs

		case "${ARCHITECTURE}" in
			amd64)
				case "${FLAVOUR}" in
					gnome-desktop)
						mkdir -p config/chroot_local-hooks
						echo "apt-get remove --yes --purge openoffice.org-help-en-us" > config/chroot_local-hooks/package-removals
						echo "apt-get remove --yes --purge epiphany-browser epiphany-browser-data epiphany-extensions epiphany-gecko" >> config/chroot_local-hooks/package-removals
						echo "apt-get remove --yes --purge gnome-user-guide" >> config/chroot_local-hooks/package-removals

						INDICES="none"
						;;

					kde-desktop)
						INDICES="none"
						;;
				esac
				;;

			i386)
				case "${FLAVOUR}" in
					standard|rescue|lxde-desktop|xfce-desktop)
						INDICES="enabled"
						;;

					gnome-desktop|kde-desktop)
						KERNEL="-k 686"
						INDICES="none"
						;;
				esac
				;;
		esac

		if [ "${SOURCE}" = "enabled" ]
		then
			lh config -p ${FLAVOUR} --cache-stages "bootstrap rootfs" --apt-recommends disabled --binary-indices ${INDICES} --tasksel aptitude ${KERNEL} --source enabled  --hostname tracker1 --username irouter --iso-application "Tracker iRouter" --packages "openjdk-6-jre-headless ssh" --iso-preparer "Verticon, Inc. Tracker; http://tracker.verticon.com/index.html" --iso-publisher "Verticon, Inc.; http://www.verticon.com" --syslinux-timeout 5 --bootappend-live "persistent ip=frommedia"
		else
			lh config -p ${FLAVOUR} --cache-stages "bootstrap rootfs" --apt-recommends disabled --binary-indices ${INDICES} --tasksel aptitude ${KERNEL} --source disabled --hostname tracker1 --username irouter --iso-application "Tracker iRouter" --packages "openjdk-6-jre-headless ssh" --iso-preparer "Verticon, Inc. Tracker; http://tracker.verticon.com/index.html" --iso-publisher "Verticon, Inc.; http://www.verticon.com" --syslinux-timeout 5 --bootappend-live "persistent ip=frommedia"
		fi

        # Copy all the iRouter files into the config
		cp -fr ${IROUTERINCLUDES}/* config
		
		
		if [ "${DISTRIBUTION}" = "sid" ]
		then
			echo 'deb http://live.debian.net/debian/ ./' > config/chroot_sources/live-snapshots.chroot
			echo 'deb http://live.debian.net/debian/ ./' > config/chroot_sources/live-snapshots.boot

			wget http://live.debian.net/debian/archive-key.asc -O config/chroot_sources/live-snapshots.chroot.gpg
			wget http://live.debian.net/debian/archive-key.asc -O config/chroot_sources/live-snapshots.binary.gpg

		fi

		lh build 2>&1 | tee tracker-${DISTRIBUTION}-${ARCHITECTURE}-${VERSION}.iso.log

		mv binary.iso tracker-${DISTRIBUTION}-${ARCHITECTURE}-${VERSION}.iso
		mv binary.list tracker-${DISTRIBUTION}-${ARCHITECTURE}-${VERSION}.iso.list
		mv binary.packages tracker-${DISTRIBUTION}-${ARCHITECTURE}-${VERSION}.iso.packages

		if [ "${SOURCE}" = "enabled" ]
		then
			mv source.tar.gz tracker-${DISTRIBUTION}-source-${VERSION}.tar.gz
			mv source.list tracker-${DISTRIBUTION}-source-${VERSION}.tar.gz.list
		fi

		lh clean --binary
		lh config -b usb-hdd
		lh binary 2>&1 | tee tracker-${DISTRIBUTION}-${ARCHITECTURE}-${VERSION}.img.log

		mv binary.img tracker-${DISTRIBUTION}-${ARCHITECTURE}-${VERSION}.img
		mv binary.list tracker-${DISTRIBUTION}-${ARCHITECTURE}-${VERSION}.img.list
		mv binary.packages tracker-${DISTRIBUTION}-${ARCHITECTURE}-${VERSION}.img.packages

		lh clean --binary
		lh config -b net
		lh binary 2>&1 | tee tracker-${DISTRIBUTION}-i386-${VERSION}-net.tar.gz.log

		mv binary-net.tar.gz tracker-${DISTRIBUTION}-i386-${VERSION}-net.tar.gz
		mv binary.list tracker-${DISTRIBUTION}-i386-${VERSION}-net.tar.gz.list
		mv binary.packages tracker-${DISTRIBUTION}-i386-${VERSION}-net.tar.gz.packages

		mv binary/*/filesystem.squashfs tracker-${DISTRIBUTION}-i386-${VERSION}.squashfs
	done
done
