-ignorewarnings
-dontobfuscate
-dontwarn

-keep class javax.** { *; }

# we don't load kotlin-stdlib when running projects for better performance,
# so these will classes be needed at runtime by the programs.
-keep class kotlin.** { *; }

# for kotlin compiler
-keep class com.intellij.** { *; }
-keep class org.jetbrains.kotlin.** { *; }
-keep class org.xml.sax.** { *; }
-keep class com.sun.xml.internal.stream.** { *; }

# proguard's merging breaks gson
-keep,allowshrinking class org.jf.util.** { *; }
-keep,allowshrinking class org.jf.dexlib2.** { *; }

# for disassembler (javap)
-keep,allowshrinking class com.sun.tools.classfile.** { *; }
