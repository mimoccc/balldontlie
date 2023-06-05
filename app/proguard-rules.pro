# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-dontnote

-keepattributes Signature

-dontwarn javax.lang.model.SourceVersion
-dontwarn javax.lang.model.element.AnnotationMirror
-dontwarn javax.lang.model.element.Element
-dontwarn javax.lang.model.element.ExecutableElement

-dontwarn javax.persistence.Basic
-dontwarn javax.persistence.Column
-dontwarn javax.persistence.Entity
-dontwarn javax.persistence.EnumType
-dontwarn javax.persistence.Enumerated
-dontwarn javax.persistence.FetchType
-dontwarn javax.persistence.GeneratedValue
-dontwarn javax.persistence.Id
-dontwarn javax.persistence.JoinColumn
-dontwarn javax.persistence.ManyToOne
-dontwarn javax.persistence.OneToOne
-dontwarn javax.persistence.Table
-dontwarn javax.persistence.Version

-dontwarn javax.tools.Diagnostic$Kind

-dontwarn org.slf4j.Logger
-dontwarn org.slf4j.LoggerFactory
-keep @interface org.mjdev.balldontlie.base.annotations** { *; }

-keep class javax.lang.model.** { *; }
-keep class javax.lang.** { *; }
-keep class javax.persistence.** { *; }
-keep class javax.tools.Diagnostic.** { *; }
-keep class org.mjdev.balldontlie.base.annotations.** { *; }

-keep class com.j256.**
-keepclassmembers class com.j256.** { *; }
-keep enum com.j256.**
-keepclassmembers enum com.j256.** { *; }
-keep interface com.j256.**
-keepclassmembers interface com.j256.** { *; }

-keepclassmembers class * {
  public <init>(android.content.Context);
}

-keepattributes *Annotation*
-keeppackagenames