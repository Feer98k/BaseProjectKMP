# -----------------------------------------
# --- SKIKO (evita problemas no iOS MP) ---
# -----------------------------------------
-keep class org.jetbrains.skiko.** { *; }

# -----------------------------------------
# --- GERAIS ---
# -----------------------------------------

# Garante que classes do seu domínio (úteis em runtime) não sejam ofuscadas
-keep class com.f98k.tipstermindcocoapods.** { *; }

# Evita problemas com serialização/reflection
-keep @kotlinx.serialization.Serializable class ** { *; }
-keep class kotlinx.serialization.** { *; }
-keep class kotlin.Metadata { *; }

# Evita problemas com sealed/enums usados via reflection
-keepclassmembers enum * { *; }

# Preserva nomes de campos e classes anotadas (caso use DI, JSON, etc.)
-keepattributes *Annotation*

# -----------------------------------------
# --- AJUSTES FINAIS ---
# -----------------------------------------

# Remove logs no release
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
    public static *** w(...);
    public static *** e(...);
}

# Garante visibilidade das classes do Compose
-keep class androidx.compose.** { *; }
-dontwarn androidx.compose.**

# Garante visibilidade do código do Koin
-keep class org.koin.** { *; }
-dontwarn org.koin.**

# Garante compatibilidade com Firebase Remote Config (se necessário)
-keep class com.google.firebase.remoteconfig.** { *; }
-dontwarn com.google.firebase.remoteconfig.**

# Garante compatibilidade com Moko (caso use reflection)
-keep class dev.icerock.moko.** { *; }
-dontwarn dev.icerock.moko.**

# -----------------------------------------
# --- MULTIPLATFORM KTOR (iOS/Android) ---
# -----------------------------------------
-keep class io.ktor.** { *; }
-dontwarn io.ktor.**
