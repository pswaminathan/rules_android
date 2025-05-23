# Description:
#   Collection of dex utilities used in the bazel android actions.

load("@rules_java//java:defs.bzl", "java_binary", "java_import", "java_library")
load("//tools/android:defs.bzl", "run_singlejar")

filegroup(
    name = "srcs",
    srcs = glob(["**"]),
    visibility = [
        "//src/test/java/com/google/devtools/build/android/dexer:__pkg__",
        "//src/tools/java/com/google/devtools/build/android:__pkg__",
    ],
)

run_singlejar(
    name = "android_dex_from_android_tools_gen",
    srcs = ["@android_tools//:all_android_tools_deploy.jar"],
    out = "android_dex_from_android_tools.jar",
    include_prefixes = [
        "com/android/dex/",
    ],
)

java_import(
    name = "android_dex_from_android_tools",
    jars = [":android_dex_from_android_tools_gen"],
)

java_binary(
    name = "DexFileSplitter",
    srcs = [
        "AsyncZipOut.java",
        "DexFileSplitter.java",
        "DexLimitTracker.java",
        "ZipEntryComparator.java",
        "ZipEntryPredicates.java",
    ],
    visibility = ["//visibility:public"],
    deps = [
        ":DexFileSplitter_lib",
        ":android_dex_from_android_tools",
        "//src/tools/java/com/google/devtools/build/android:android_builder_lib",
        "//src/tools/java/com/google/devtools/build/android:android_options_utils",
        "//tools/android:autovalue",
        "@rules_android_maven//:com_beust_jcommander",
        "@rules_android_maven//:com_google_code_findbugs_jsr305",
        "@rules_android_maven//:com_google_errorprone_error_prone_annotations",
        "@rules_android_maven//:com_google_guava_guava",
    ],
)

java_library(
    name = "DexFileSplitter_lib",
    srcs = [
        "AsyncZipOut.java",
        "DexFileSplitter.java",
        "DexLimitTracker.java",
        "ZipEntryComparator.java",
        "ZipEntryPredicates.java",
    ],
    visibility = ["//src/test/java/com/google/devtools/build/android/dexer:__pkg__"],
    deps = [
        ":android_dex_from_android_tools",
        "//src/tools/java/com/google/devtools/build/android:android_builder_lib",
        "//src/tools/java/com/google/devtools/build/android:android_options_utils",
        "//tools/android:autovalue",
        "@bazel_worker_api//:worker_protocol_proto",
        "@rules_android_maven//:com_beust_jcommander",
        "@rules_android_maven//:com_google_auto_value_auto_value",
        "@rules_android_maven//:com_google_code_findbugs_jsr305",
        "@rules_android_maven//:com_google_errorprone_error_prone_annotations",
        "@rules_android_maven//:com_google_guava_guava",
    ],
)

# The DexFileMerger and DexBuilder are built in BUILD.tools which is built in
# a developers workspace, not the Bazel workspace. So we must bundle the
# dependencies of those binaries into the embedded tools.
java_library(
    name = "dexerdeps",
    visibility = [
        "//src/tools/java/com/google/devtools/build/android:__pkg__",
    ],
    runtime_deps = [
        "//src/tools/java/com/google/devtools/build/android:android_builder_lib",
        "@bazel_worker_api//:worker_protocol_proto",
        "@rules_android_maven//:com_google_auto_value_auto_value",
        "@rules_android_maven//:com_google_code_findbugs_jsr305",
        "@rules_android_maven//:com_google_guava_guava",
    ],
)
