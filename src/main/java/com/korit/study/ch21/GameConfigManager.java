package com.korit.study.ch21;

import java.util.Objects;

public class GameConfigManager {
    private static GameConfigManager instance;  // instatnce 싱글톤 변수 생성

    // 설정 정보 필드들
    private int soundVolume = 50;           // 기본값 50
    private String resolution = "1280x720"; // 기본 해상도

    // 기본값이 이미 생성되어 있는 상태이기 때문에 아무것도 없는 생성자 생성
    private GameConfigManager() {

    }

    // 인스턴스 반환 메서드 getter
    public static GameConfigManager getInstance() {
        if (Objects.isNull(instance)){
            instance = new GameConfigManager();
        }
        return instance;
    }

    // Getter/Setter 메서드들
    public void setSoundVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.soundVolume = volume;
        }
    }

    public int getSoundVolume() {
        return soundVolume;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }

    public String getConfigInfo() {
        return String.format("Sound: %d, Resolution: %s",
                soundVolume, resolution);
    }
}
