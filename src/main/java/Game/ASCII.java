package Game;

import Table.AsciiTable;

import java.util.List;

public class ASCII {
    public void print(List<String> moves) {
        int countOfMoves = moves.size();
        String[] headers = new String[countOfMoves + 1];
        headers[0] = "You/Computer";
        for (int i = 1; i < countOfMoves + 1; i++) {
            headers[i] = moves.get(i - 1);
        }
        String[][] rules = new String[countOfMoves][countOfMoves];
        for (int i = 0; i < countOfMoves; i++) {
            for (int j = 1; j <= countOfMoves /2; j++) {
                rules[i][(i+j+ countOfMoves)% countOfMoves] = "Win";
                rules[i][(i-j+ countOfMoves)% countOfMoves] = "Lose";
            }
            rules[i][i] = "Draw";
        }
        String[][] dataForTable = new String[countOfMoves][countOfMoves + 1];
        for (int i = 0; i < countOfMoves; i++) {
            dataForTable[i][0] = moves.get(i);
            for (int j = 1; j < countOfMoves + 1; j++) {
                dataForTable[i][j] = rules[i][j-1];
            }
        }
        System.out.println(AsciiTable.getTable(headers, dataForTable));
        System.out.print("Your selection:");
    }
}
