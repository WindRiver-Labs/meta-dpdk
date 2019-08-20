include dpdk.inc

STABLE = "-stable"
BRANCH = "18.11"
SRCREV = "16ece46735c9b70b7033ca7ae095930e9038d9fd"

LICENSE = "BSD-3-Clause & LGPLv2.1 & GPLv2"
LIC_FILES_CHKSUM = "file://license/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://license/lgpl-2.1.txt;md5=4b54a1fd55a448865a0b32d41598759d \
                    file://license/bsd-3-clause.txt;md5=0f00d99239d922ffd13cabef83b33444"

do_install_append () {
    # Remove the unneeded dir
    rm -rf ${D}/${INSTALL_PATH}/${RTE_TARGET}/app
}

DEFAULT_PREFERENCE = "-1"

python do_fetch_prepend () {
    supported_machines = ["marvell-cn91xx", "marvell-cn96xx"]
    machine = d.getVar('MACHINE')
    if machine not in supported_machines:
        bb.fatal("Sorry, this version of DPDK is only supposed to run on machine: %s" % supported_machines)
}