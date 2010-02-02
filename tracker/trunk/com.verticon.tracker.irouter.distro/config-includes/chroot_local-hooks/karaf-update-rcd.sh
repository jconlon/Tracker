#!/bin/sh
# lamp-update-rcd.sh

# Make the init script executable
chown root:root /etc/init.d/karaf-service
chmod 755 /etc/init.d/karaf-service

# Create symlinks for each runlevel
# eg /etc/rc2.d/S90karaf-service for runlevel 2, etc
update-rc.d karaf-service defaults 90 10