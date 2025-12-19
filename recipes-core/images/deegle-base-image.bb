SUMMARY = "Deegle Linux base image."

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"

# DEEGLE_USB_ETHERNET
# kea dhcp server for usb ethernet
# kernel modules for g_ether

# DEEGLE_GPIO_SUPPORT
# libgpiod and libgpiod-tools for GPIO access

# ID: DEEGLE_I2C_SUPPORT
# i2c-tools for I2C access

IMAGE_INSTALL:append = " \
    kernel-modules \
    usbinit \
    vim \
    iputils-ping \
    net-tools \
    lshw \
    kea \
    libgpiod \
    libgpiod-tools \
    i2c-tools \
"
