package org.example.Classes.GameType;

import org.example.Classes.Abstract.Game;
import org.example.Intarfaces.GameInterface;
import java.util.ArrayList;
import java.util.List;

public class NumberGame extends Game {

    @Override
    public List<String> generateCharList() {
        List<String> charList = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            charList.add(Integer.toString(i));
        }
        return charList;
    }
}