FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
           file://0001-Added-password-mask-delay.patch;patch=1 \
           file://0002-QWaylandWindow-reset-window-should-reset-mask.patch;patch=1 \
           file://0003-QtKeyExtensionGlobal-fix-export.patch;patch=1 \
           "

FILES_${PN} += "${OE_QMAKE_PATH_PLUGINS}/wayland-graphics-integration"
FILES_${PN}-dbg += "${OE_QMAKE_PATH_PLUGINS}/wayland-graphics-integration/*/.debug"
