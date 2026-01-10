package gay.pyrrha.orbital.di.service

public interface PlatformService {
    public val platformKey: String
    public fun isModLoaded(id: String): Boolean
}