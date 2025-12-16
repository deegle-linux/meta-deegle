
PACKAGECONFIG:append = " networkd "

PACKAGECONFIG:remove = " timesyncd "

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# DEEGLE_USB_ETHERNET
# configure usb0 network interface

SRC_URI += "file://usb.network \
            file://0001-only-wait-for-any-device.patch \
            "

FILES:${PN} += " \
    ${sysconfdir}/systemd/network/usb.network \
"

do_configure:append() {
    sed -i -e "s/enable systemd-resolved.service/disable systemd-resolved.service/g" ${S}/presets/90-systemd.preset
    sed -i -e "s/enable systemd-timesyncd.service/disable systemd-timesyncd.service/g" ${S}/presets/90-systemd.preset
}

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/usb.network ${D}${sysconfdir}/systemd/network
}
