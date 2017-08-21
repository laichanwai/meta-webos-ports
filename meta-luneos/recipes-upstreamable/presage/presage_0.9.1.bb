SECTION = "libs"
DESCRIPTION = "Presage is an intelligent predictive text entry system."

LICENSE = "GPL-2.0+"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

DEPENDS = "sqlite3 libtinyxml ncurses"
DEPENDS_append_class-target = " presage-native"

BBCLASSEXTEND = "native"

inherit autotools gettext pkgconfig python-dir

SRC_URI = " \
    http://downloads.sourceforge.net/${BPN}/${BP}.tar.gz \
    file://disable-help2man.patch \
    file://fix.build.with.gcc-6.patch \
    file://fix.build.with.gcc-7.patch \
"

SRC_URI[md5sum] = "9667be297912fa0d432e748526d8dd9e"
SRC_URI[sha256sum] = "5ed567e350402a1d72c9053c78ecec3be710b7e72153a0223c6d19a7fe58a366"

EXTRA_OECONF = " \
    --disable-documentation \
    --disable-gpresagemate \
    --disable-gprompter \
    --disable-python-binding \
"

FILES_${PN} += "\
    ${libdir}/${PYTHON_DIR} \
    ${libdir}/${PYTHON_DIR}/dist-packages \
    ${libdir}/${PYTHON_DIR}/dist-packages/presage_dbus_service.pyc \
    ${libdir}/${PYTHON_DIR}/dist-packages/presage_dbus_service.pyo \
    ${libdir}/${PYTHON_DIR}/dist-packages/presage_dbus_service.py \
    ${datadir}/dbus-1 \
    ${datadir}/dbus-1/services \
    ${datadir}/dbus-1/services/org.gnome.presage.service \
"

do_configure_prepend_class-target() {
   sed -i "s#\$(top_builddir)/src/tools/text2ngram#${STAGING_BINDIR_NATIVE}/text2ngram#g" ${S}/resources/Makefile.am
}
