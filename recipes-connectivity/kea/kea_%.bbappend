# DEEGLE_USB_ETHERNET

SYSTEMD_AUTO_ENABLE = "enable"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://kea-dhcp4.conf \
"

FILES:${PN} += " \
    ${sysconfdir}/kea/kea-dhcp4.conf \
"

do_install:append() {
    install -d ${D}${sysconfdir}/kea
    install -m 0644 ${WORKDIR}/kea-dhcp4.conf ${D}${sysconfdir}/kea/kea-dhcp4.conf
}
