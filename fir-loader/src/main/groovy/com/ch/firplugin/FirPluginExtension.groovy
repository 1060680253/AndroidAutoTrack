package com.ch.firplugin

class FirPluginExtension {
    String changeLog = ""
    boolean upload = false
    String version = null
    boolean attachAssembleRelease = true

    Map<String, String> apiTokens

    void changeLog(File file) {
        if (file != null && file.exists()) {
            changeLog = file.text
        } else {
            println "changeLog [$file] was null or not exists"
        }
    }

    void changeLog(String log) {
        changeLog = log
    }

    void apiToken(String apiToken) {
        if (apiTokens == null) {
            apiTokens = new HashMap<>()
        }
        apiTokens.put("main", apiToken)
    }
}
