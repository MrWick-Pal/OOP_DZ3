package org.example.Classes.GameType;

import org.example.Classes.Abstract.Game;
import java.util.ArrayList;
import java.util.List;

public class EngGame extends Game {
    @Override
    public List<String> generateCharList() {
        List<String> charList = new ArrayList<>();
        for (int i = 'a'; i < 'z'; i++) {
            charList.add(Character.toString(i));
        }
        return charList;
    }
}