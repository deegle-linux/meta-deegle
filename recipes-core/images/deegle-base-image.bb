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
# libgpiod and python3-gpio for GPIO access

IMAGE_INSTALL:append = " \
    kernel-modules \
    usbinit \
    vim \
    iputils-ping \
    net-tools \
    lshw \
    kea \
    python3 \
    libgpiod \
    libgpiod-dev \
    libgpiod-tools \
    python3-gpiod \
"
