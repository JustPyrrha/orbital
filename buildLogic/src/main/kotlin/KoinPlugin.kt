import com.google.devtools.ksp.gradle.KspExtension
import gay.pyrrha.orbital.build.findPluginId
import gay.pyrrha.orbital.build.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class KoinPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(libs.findPluginId("ksp"))

            dependencies {
                add("implementation", libs.findLibrary("koin-core").get())
                add("implementation", libs.findLibrary("koin-annotations").get())
                add("ksp", libs.findLibrary("koin-ksp").get())
            }

            extensions.configure<KspExtension> {
                arg("KOIN_CONFIG_CHECK", "true")
            }
        }
    }
}
