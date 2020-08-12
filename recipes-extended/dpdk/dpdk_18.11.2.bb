include dpdk.inc

STABLE = "-stable"
BRANCH = "18.11"
SRCREV = "06c4b12a5968caea61e96f7d6bd29d2726fbe255"

LICENSE = "BSD-3-Clause & LGPLv2.1 & GPLv2"
LIC_FILES_CHKSUM = "file://license/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://license/lgpl-2.1.txt;md5=4b54a1fd55a448865a0b32d41598759d \
                    file://license/bsd-3-clause.txt;md5=0f00d99239d922ffd13cabef83b33444"

SRC_URI += "\
        file://dpdk-18.11-igb_uio-fix-build-on-Linux-5.3-for-fall-through.patch \
"
SRC_URI += "${@bb.utils.contains('PREFERRED_PROVIDER_virtual/kernel',\
            'linux-yocto-rt',\
            'file://dpdk-18.11-igb_uio-change-ISR-to-be-threaded-when-using-with-RT.patch',\
            '',d)}"

do_install_append () {
    # Remove the unneeded dir
    rm -rf ${D}/${INSTALL_PATH}/${RTE_TARGET}/app
}