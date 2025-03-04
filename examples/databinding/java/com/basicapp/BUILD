load("@rules_android//android:rules.bzl", "android_binary", "android_library")

android_binary(
    name = "basic_app",
    manifest = "AndroidManifest.xml",
    enable_data_binding = True,
    deps = [
        ":basic_lib",
        "@maven//:androidx_databinding_databinding_runtime",
    ],
)

android_library(
    name = "basic_lib",
    srcs = ["BasicActivity.java"],
    manifest = "AndroidManifest.xml",
    resource_files = glob(["res/**"]),
    enable_data_binding = True,
    deps = [
        "@maven//:androidx_annotation_annotation_jvm",
        "@maven//:androidx_databinding_databinding_runtime",
    ],
)
