# Description:
#   Blaze mobile-install aspect package.

load("@bazel_skylib//:bzl_library.bzl", "bzl_library")

package(
    default_applicable_licenses = ["//:license"],
    default_visibility = ["//:__subpackages__"],
)

licenses(["notice"])

exports_files(["mi.bzl"])

filegroup(
    name = "all_files",
    srcs = glob(["**"]) + ["//mobile_install/adapters:all_files"],
)

bzl_library(
    name = "bzl",
    srcs = glob(
        ["**/*.bzl"],
        exclude = [
            "constants.bzl",
            "providers.bzl",
            "resources.bzl",
            "transform.bzl",
            "utils.bzl",
            "launcher_direct.bzl",
        ],
    ),
    deps = [
        ":providers",
        ":transform",
        ":utils",
        "//mobile_install/adapters:bzl",
        "//rules:min_sdk_version_bzl",
        "//rules:utils_bzl",
        "//rules:visibility_bzl",
        "//rules/flags:bzl",
        "@rules_java//java/common",
    ],
)

bzl_library(
    name = "constants",
    srcs = ["constants.bzl"],
    deps = ["//rules:visibility_bzl"],
)

bzl_library(
    name = "launcher_direct",
    srcs = ["launcher_direct.bzl"],
    deps = [
        "utils",
        ":providers",
        "//rules:visibility_bzl",
    ],
)

bzl_library(
    name = "providers",
    srcs = ["providers.bzl"],
    deps = ["//rules:visibility_bzl"],
)

bzl_library(
    name = "resources",
    srcs = ["resources.bzl"],
    deps = [
        ":constants",
        ":utils",
        "//rules:visibility_bzl",
    ],
)

bzl_library(
    name = "transform",
    srcs = ["transform.bzl"],
    deps = [
        ":constants",
        ":utils",
        "//rules:visibility_bzl",
        "//rules/flags:bzl",
    ],
)

bzl_library(
    name = "utils",
    srcs = ["utils.bzl"],
    deps = [
        ":constants",
        "//rules:min_sdk_version_bzl",
        "//rules:visibility_bzl",
        "//rules/flags:bzl",
        "@rules_java//java/common",
    ],
)
