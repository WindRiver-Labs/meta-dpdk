include dpdk.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI[dpdk.md5sum] = "75a2f0922baadc19dc8a222a7547798a"
SRC_URI[dpdk.sha256sum] = "47f43a3ef66cc351ab639ae313830dc08760089c7d227e5f73daa0d6df38b201"

S = "${WORKDIR}/${BPN}-stable-${PV}"
export EXAMPLES_BUILD_DIR = "${RTE_TARGET}"
export ARCHDIR = "generic"

do_configure_prepend () {
	sed -e "s#CONFIG_RTE_LIBRTE_POWER=y#CONFIG_RTE_LIBRTE_POWER=${CONFIG_EXAMPLE_VM_POWER_MANAGER}#" -i ${S}/config/common_linuxapp
}

COMPATIBLE_HOST_linux-gnux32 = "null"
COMPATIBLE_HOST_libc-musl_class-target = "null"

SRC_URI += " file://0001-eventdev-extend-the-eventdev-capability-flags.patch \
	file://0002-bus-fslmc-add-support-for-dynamic-IOVA-for-DPAA2.patch \
	file://0003-net-dpaa2-link-status-check-as-driver-flag.patch \
	file://0004-bus-fslmc-expose-platform-SoC-value-register.patch \
	file://0005-bus-fslmc-add-braces-for-pointers-in-macros.patch \
	file://0006-bus-fslmc-add-qman-HW-fq-query-count-API.patch \
	file://0007-net-dpaa2-add-Rx-queue-count-support.patch \
	file://0008-net-dpaa2-align-the-frame-size-in-MTU-set.patch \
	file://0009-net-dpaa2-add-VLAN-insert-offload.patch \
	file://0010-net-dpaa2-add-parse-function-for-LX2-device.patch \
	file://0011-net-dpaa2-optimize-Rx-path-packet-parsing.patch \
	file://0012-net-dpaa2-optimize-Tx-path-for-best-case.patch \
	file://0013-net-dpaa2-prefetch-the-parse-results-from-next-fd.patch \
	file://0014-net-dpaa2-change-vlan-filter-rule-to-be-called-on-co.patch \
	file://0015-net-dpaa2-use-HASH-FLCTYPE-only-for-LX2.patch \
	file://0016-bus-fslmc-disable-eventdev-config-with-no-dpaa2-even.patch \
	file://0017-bus-fslmc-change-the-eqcr-stashing-threshold-to-1.patch \
	file://0018-bus-fslmc-add-support-for-scanned-device-count.patch \
	file://0019-bus-dpaa-update-platform-soc-value-register-routines.patch \
	file://0020-net-dpaa-set-the-correct-frame-size-in-device-MTU.patch \
	file://0021-net-dpaa-add-frame-count-based-tail-drop-with-CGR.patch \
	file://0022-bus-dpaa-optimize-the-qman-HW-stashing-settings.patch \
	file://0023-bus-dpaa-optimize-the-endianness-conversions.patch \
	file://0024-bus-dpaa-add-support-to-create-dynamic-HW-portal.patch \
	file://0025-net-dpaa-change-Tx-HW-budget-to-7.patch \
	file://0026-net-dpaa-optimize-the-Tx-burst.patch \
	file://0027-net-dpaa-optimize-Rx-path.patch \
	file://0028-bus-dpaa-query-queue-frame-count-support.patch \
	file://0029-net-dpaa-add-Rx-queue-count-support.patch \
	file://0030-net-dpaa-add-support-for-loopback-API.patch \
	file://0031-app-testpmd-add-support-for-loopback-config-for-dpaa.patch \
	file://0032-bus-dpaa-add-support-for-static-queues.patch \
	file://0033-net-dpaa-integrate-the-support-of-push-mode-in-PMD.patch \
	file://0034-bus-dpaa-support-for-enqueue-frames-of-multiple-queu.patch \
	file://0035-examples-ipsec-secgw-add-cryptodev-mask-option.patch \
	file://0036-event-dpaa2-return-correct-number-of-event-ports.patch \
	file://0037-config-enabling-compilation-of-DPAA-eventdev-PMD.patch \
	file://0038-bus-dpaa-add-event-dequeue-and-consumption-support.patch \
	file://0039-bus-dpaa-add-dpaa-eventdev-dynamic-log-support.patch \
	file://0040-net-dpaa-ethdev-Rx-queue-configurations-with-eventde.patch \
	file://0041-event-dpaa-add-eventdev-PMD.patch \
	file://0042-event-dpaa-add-event-queue-config-get-set-support.patch \
	file://0043-event-dpaa-add-event-port-config-get-set-support.patch \
	file://0044-event-dpaa-add-eth-rx-adapter-queue-config-support.patch \
	file://0045-event-dpaa-add-eventdev-enqueue-dequeue-support.patch \
	file://0046-doc-add-DPAA-eventdev-guide.patch \
	file://0047-event-dpaa2-replace-static-with-dynamic-logging.patch \
	file://0048-bus-fslmc-introduce-API-to-consume-dqrr-using-index.patch \
	file://0049-event-dpaa2-use-dqrr-index-to-cosume-the-DQRR-entry.patch \
	file://0050-event-dpaa2-have-separate-structure-to-hold-dqrr-ent.patch \
	file://0051-bus-fslmc-add-flag-to-configure-DCA-in-QBMAN-multi-T.patch \
	file://0052-net-dpaa2-support-atomic-queues.patch \
	file://0053-examples-ipsec-secgw-update-mbuf-packet-type.patch \
	file://0054-examples-ipsec-secgw-improve-ipsec-dequeue-logic.patch \
	file://0055-crypto-dpaa_sec-optimize-virt-to-phy-conversion.patch \
	file://0056-crypto-dpaa_sec-support-multiple-sessions-per-qp.patch \
	file://0057-crypto-dpaa_sec-support-ipsec-protocol-offload.patch \
	file://0058-crypto-dpaa_sec-rewrite-Rx-Tx-path.patch \
	file://0059-vfio-expose-clear-group-function-for-internal-usages.patch \
	file://0060-bus-fslmc-clear-the-vfio-group-on-error.patch \
	file://0061-net-dpaa2-support-more-than-16-burst-size-in-Rx-func.patch \
	file://0062-net-dpaa2-optimize-Rx-Tx-path.patch \
	file://0063-crypto-dpaa-retire-fq-while-detaching-with-session.patch \
	file://0064-kni-support-for-MAC-addr-change.patch \
	file://0065-kni-add-support-for-promisc-mode-set.patch \
	file://0066-kni-set-initial-value-for-MTU.patch \
	file://0067-examples-l3fwd-power-replace-desc-done-with-Rx-queue.patch \
	file://0068-examples-l3fwd-power-disable-Lsc-interrupts.patch \
	file://0069-mempool-dpaa-optimize-phy-to-virt-conversion.patch \
	file://0070-crypto-dpaa2_sec-support-for-scatter-gather.patch \
	file://0071-crypto-dpaa_sec-support-for-scatter-gather.patch \
	file://0072-bus-fslmc-create-function-to-prefetch-next-DQRR-entr.patch \
	file://0073-event-dpaa2-prefetch-the-next-DQRR-entry.patch \
	file://0074-net-dpaa2-prefetch-the-annotation-in-event-processin.patch \
	file://0075-bus-dpaa-check-flag-in-qman-multi-enqueue.patch \
	file://0076-bus-dpaa-allocate-qman-portals-in-thread-safe-manner.patch \
	file://0077-mempool-dpaa-fix-the-phy-to-virt-optimization.patch \
	file://0078-bus-dpaa-fix-port-order-shuffling.patch \
	file://0079-net-dpaa-use-phy-to-virt-optimizations.patch \
	file://0080-bus-dpaa-check-portal-presence-in-the-caller-API.patch \
	file://0081-net-dpaa-further-push-mode-optimizations.patch \
	file://0082-PVT-config-change-dpaa2-mbuf-headroom-size-to-128.patch \
	file://0083-PVT-net-dpaa2-fix-the-bpid-offset.patch \
	file://0084-PVT-net-dpaa2-fix-the-err-with-testpmd-in-Tx-only-mo.patch \
	file://0085-PVT-net-dpaa2-make-Rx-taildrop-to-be-runtime-configu.patch \
	file://0086-PVT-net-dpaa2-make-parse-error-drops-to-be-configura.patch \
	file://0087-PVT-net-dpaa2-enable-TX-congestion-configurable.patch \
	file://0088-PVT-bus-fslmc-dpio-affinity-for-virtual-m-c-using-en.patch \
	file://0089-PVT-mbuf-overwrite-default-mempool-ops-with-hw-activ.patch \
	file://0090-PVT-dpaa2-register-dpaa2-mempool-ops-as-platform-mem.patch \
	file://0091-PVT-dpaa-register-dpaa-mempool-ops-as-platform-mempo.patch \
	file://0092-PVT-config-dpaa-to-compile-all-dpaa-platforms.patch \
	file://0093-PVT-config-dpaa-disable-igb-uio-compliation.patch \
	file://0094-PVT-config-dpaa2-disable-igb-uio-compliation.patch \
	file://0095-PVT-nxp-specific-scripts-and-folders.patch \
	file://0096-PVT-nxp-add-ipsec-cfg-files-for-dpaa1-use-cases.patch \
	file://0097-PVT-dpaa-Remove-dot-from-NXP-copyright.patch \
	file://0098-PVT-dpaa2-remove-DOT-from-nxp-copyright.patch \
	file://0099-PVT-MISC-remove-DOT-from-nxp-copyright.patch \
	file://0100-PVT-vhost-enabled-vhost-switch-application.patch \
	file://0101-PVT-vhost-multi-ports-support-added.patch \
	file://0102-PVT-net-dpaa-add-support-for-ucode-based-mode.patch \
	file://0103-PVT-nxp-Add-XML-files-required-for-ucode-support.patch \
	file://0104-PVT-net-dpaa-add-support-for-dynamic-queue-based-dis.patch \
	file://0105-PVT-net-dpaa-enhance-errata-workaround-for-LS1043.patch \
	file://0106-PVT-mbuf-Patch-to-fix-LS1043-errata-of-fq-stalls.patch \
	file://0107-PVT-mempool-Performance-increment-for-errata-fix.patch \
	file://0108-PVT-net-dpaa2-add-no-Prefetch-based-Rx-dequeue-mode.patch \
	file://0109-PVT-preserve-API-to-fetch-more-than-16-packets.patch \
	file://0110-bus-fslmc-register-dpaa2-mempool-only-once.patch \
	file://0111-event-dpaa-rename-dpaa-vdev-with-dpaa1.patch \
	file://0112-event-dpaa-fix-portal-allocation.patch \
	file://0113-PVT-bus-fslmc-change-vfio-irq-mapping-failure-to-deb.patch \
	file://0114-eal-add-test-assert-macros.patch \
	file://0115-rawdev-introduce-raw-device-library.patch \
	file://0116-rawdev-add-attribute-get-and-set.patch \
	file://0117-rawdev-add-buffer-stream-IO.patch \
	file://0118-rawdev-add-extended-stats.patch \
	file://0119-rawdev-add-firmware-management.patch \
	file://0120-rawdev-add-self-test.patch \
	file://0121-raw-skeleton-introduce-skeleton-rawdev-driver.patch \
	file://0122-raw-skeleton-add-test-cases.patch \
	file://0123-test-enable-rawdev-skeleton-test.patch \
	file://0124-doc-add-rawdev-library-guide-and-doxygen-page.patch \
	file://0125-raw-skeleton_rawdev-fix-device-start-test.patch \
	file://0126-PVT-net-dpaa-update-checksum-for-external-pool-obj.patch \
	file://0127-crypto-dpaa_sec-move-mempool-allocation-to-configura.patch \
	file://0128-crypto-dpaa_sec-fix-incorrect-NULL-check.patch \
	file://0129-PVT-mempool-dpaa2-add-functions-exposed-to-DPDK-appl.patch \
	file://0130-PVT-bus-fslmc-expose-API-to-free-dpci-device.patch \
	file://0131-PVT-bus-fslmc-keep-tx-queues-information-for-DPCI-de.patch \
	file://0132-PVT-bus-fslmc-add-preprocessors-to-get-flc-and-frc-f.patch \
	file://0133-PVT-raw-dpaa2_cmdif-introduce-the-DPAA2-command-inte.patch \
	file://0134-PVT-raw-dpaa2_cmdif-add-attribute-get-functionality.patch \
	file://0135-PVT-raw-dpaa2_cmdif-support-enqueue-dequeue-operatio.patch \
	file://0136-PVT-doc-add-DPAA2-CMDIF-rawdev-guide.patch \
	file://0137-PVT-examples-cmdif-add-CMDIF-client-library.patch \
	file://0138-PVT-examples-cmdif-add-CMDIF-server-library.patch \
	file://0139-PVT-examples-cmdif-add-CMDIF-SHBP-library.patch \
	file://0140-PVT-examples-cmdif-add-the-command-interface-demo-ap.patch \
	file://0141-PVT-doc-add-DPAA2-based-CMDIF-demo.patch \
	file://0142-PVT-bus-fslmc-add-typecast-in-iova-vaddr-conversion-.patch \
	file://0143-PVT-raw-dpaa2_cmdif-use-iova-vaddr-conversion-macros.patch \
	file://0144-PVT-examples-l3fwd-adding-CLI-parameters-for-eventde.patch \
	file://0145-PVT-doc-update-the-cmdif-doc-with-correct-AIOP-ELF-p.patch \
	file://0146-net-dpaa-fix-potential-memory-leak.patch \
	file://0147-crypto-dpaa_sec-fix-enum-conversion-for-GCM.patch \
	file://0148-bus-dpaa-fix-clang-warnings.patch \
	file://0149-bus-fslmc-fix-DPCI-compare-in-scan.patch \
	file://0150-net-dpaa2-remove-unused-global-variable.patch \
	file://0151-lib-remove-unused-map-symbols.patch \
	file://0152-crypto-dpaa2_sec-fix-build-with-GCC-7.patch \
	file://0153-crypto-dpaa2_sec-fix-build-with-GCC-7.patch \
	file://0154-doc-add-DPAA-eventdev-guide.patch \
	file://0155-license-introduce-SPDX-identifiers.patch \
	file://0156-PVT-mbuf-change-mempool-set-from-register.patch \
	file://0157-README-Update-for-l3fwd-with-eventdev-config.patch \
	file://0158-dpaa-event-rearranging-of-atomic-queue-support-code.patch \
	file://0159-PVT-crypto-dpaa_sec-add-macro-for-device-name.patch \
	file://0160-PVT-test-test-add-macro-for-dpaa_sec-device-name.patch \
	file://0161-PVT-crypto-dpaa_sec-adding-a-check-to-create-mempool.patch \
	file://0162-PVT-crypto-dpaa_sec-Adding-a-check-to-verify-portal-.patch \
	file://0163-PVT-dpaa2-add-dynamic-AIOP-DPL-script.patch \
	file://0164-PVT-examples-vhost-add-NXP-NON-upstream-compilation-.patch \
	file://0165-PVT-dpaa2-Coverity-fixes.patch \
	file://0166-PVT-dpaa-Coverity-fixes.patch \
"

LICENSE = "BSD & LGPLv2 & GPLv2"
LIC_FILES_CHKSUM = "file://license/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://license/lgpl-2.1.txt;md5=4b54a1fd55a448865a0b32d41598759d \
                    file://license/bsd-3-clause.txt;md5=0f00d99239d922ffd13cabef83b33444"

python do_fetch_prepend () {
    supported_machines = ["nxp-ls20xx"]
    machine = d.getVar('MACHINE')
    if machine not in supported_machines:
        bb.fatal("Sorry, this version of DPDK is only supposed to run on machine: %s" % supported_machines)
}
