
require ovmf-ch.inc

do_compile_append_class-target() {
    ${S}/OvmfPkg/build.sh $PARALLEL_JOBS -a $OVMF_ARCH -b ${EDK_BUILD_TYPE} -t ${EDK_GCCVER} -p OvmfPkg/OvmfCh.dsc
}

do_install_class-target() {
    OVMF_TGT_DIR=${D}/usr/share/cloud-hypervisor

    install -d ${OVMF_TGT_DIR}
    install -m 644 ${S}/Build/OvmfCh/${EDK_BUILD_TYPE}_${EDK_GCCVER}/FV/OVMF.fd ${OVMF_TGT_DIR}
    install -m 644 ${S}/Build/OvmfCh/${EDK_BUILD_TYPE}_${EDK_GCCVER}/FV/OVMF_CODE.fd ${OVMF_TGT_DIR}
    install -m 644 ${S}/Build/OvmfCh/${EDK_BUILD_TYPE}_${EDK_GCCVER}/FV/OVMF_VARS.fd ${OVMF_TGT_DIR}
}

