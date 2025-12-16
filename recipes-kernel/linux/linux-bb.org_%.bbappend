FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# DEEGLE_NO_DUMMY_ETHERNET
# Disable dummy ethernet kernel module

SRC_URI += " \
    file://dummy.cfg \
"
