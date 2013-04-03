# Copyright (c) 2012-2013 LG Electronics, Inc.

SUMMARY = "Loadable frameworks for sync services"
SECTION = "webos/frameworks"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

WEBOS_VERSION = "1.1-3_0874bd27195ed99c14e6ed401efe788bbe1338c4"

#inherit webos_component
inherit webos_public_repo
inherit webos_enhanced_submissions
#inherit webos_cmake
inherit webos_arch_indep

SRC_URI = "${OPENWEBOS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${webos_frameworksdir}

    for FRAMEWORK in `ls -d1 ${S}/mojoservice*` ; do
        FRAMEWORK_DIR=`basename $FRAMEWORK`
        install -d ${D}${webos_frameworksdir}/$FRAMEWORK_DIR/version/1.0/
        cp -vrf $FRAMEWORK/* ${D}${webos_frameworksdir}/$FRAMEWORK_DIR/version/1.0/
        # remove test and jasminetest dirs
        rm -vrf ${D}${webos_frameworksdir}/$FRAMEWORK_DIR/version/1.0/*test
    done
}

FILES_${PN} += "${webos_frameworksdir}"
