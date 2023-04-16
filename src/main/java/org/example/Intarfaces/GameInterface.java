package org.example.Intarfaces;

import org.example.Classes.Answer;
import org.example.Enum.GameStatus;
public interface GameInterface {
    void start(Integer wordSize, Integer attempt);
    Answer inputValue(String value);
    GameStatus getGameStatus();
}
