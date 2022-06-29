# Kotlin
# COMMON KOTLIN
-dontnote kotlin.**
-dontwarn kotlin.**
-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}
-dontnote kotlinx.**
-keep class kotlinx.coroutines.**
# retrofit
-keepattributes Signature
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Exceptions

# okhttp
-dontwarn okio.**
-dontwarn javax.annotation.Nullable
-dontwarn javax.annotation.ParametersAreNonnullByDefault
-dontwarn javax.annotation.**
#gson
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.* { *; }
-keep public class com.google.gson.** {
    public private protected *;
}
-keep class com.google.appengine.** { *; }
-keep class com.google.gson.* { *; }
-keep class com.google.inject.* { *; }
-keep class com.google.gson.stream.** { *; }
-keepclassmembers enum * { *; }
-dontnote com.google.gson.annotations.Expose

-dontnote com.google.gson.annotations.SerializedName

#OKHTTP3
-dontwarn okhttp3.**

#pdf
-keep class com.shockwave.**