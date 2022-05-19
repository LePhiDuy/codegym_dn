package _8_clean_code.exercise.e1;

public class TennisGame {
    public static String getResultWhenScoreOverOrEqualFour(String namePlayer1, String namePlayer2, int scorePlayer1, int scorePlayer2) {
        String result = "";
        int tempScore = 0;
        boolean isFirstEqualSecond = scorePlayer1 == scorePlayer2;
        boolean isScorePlayer1MoreThan4 = scorePlayer1 >= 4;
        boolean isScorePlayer2MoreThan4 = scorePlayer2 >= 4;
        if (isFirstEqualSecond) {
            switch (scorePlayer1) {
                case 0:
                    result = "Love-All";
                    break;
                case 1:
                    result = "Fifteen-All";
                    break;
                case 2:
                    result = "Thirty-All";
                    break;
                case 3:
                    result = "Forty-All";
                    break;
                default:
                    result = "Deuce";
                    break;

            }
        } else if (isScorePlayer1MoreThan4 || isScorePlayer2MoreThan4) {
                int minusResult = scorePlayer1 - scorePlayer2;
                boolean isMinusResultEqualOne = minusResult == 1;
                boolean isMinusResultOverOrEqualTwo = minusResult >= 2;
                boolean isMinusResultEqualNegativOne = minusResult == -1;
                result = getResultWhenScoreOverOrEqualFour(isMinusResultEqualOne, isMinusResultOverOrEqualTwo, isMinusResultEqualNegativOne);
            } else {
            result = getResultWhenScoreLess4(scorePlayer1, scorePlayer2, result);
        }
        return result;
    }

    private static String getResultWhenScoreLess4(int scorePlayer1, int scorePlayer2, String result) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = scorePlayer1;
            else {
                result += "-";
                tempScore = scorePlayer2;
            }
            switch (tempScore) {
                case 0:
                    result += "Love";
                    break;
                case 1:
                    result += "Fifteen";
                    break;
                case 2:
                    result += "Thirty";
                    break;
                case 3:
                    result += "Forty";
                    break;
            }
        }
        return result;
    }

    private static String getResultWhenScoreOverOrEqualFour(boolean isMinusResultEqualOne, boolean isMinusResultOverOrEqualTwo, boolean isMinusResultEqualNegativOne) {
        String score;
        if (isMinusResultEqualOne) {
            score = "Advantage player1";
        } else if (isMinusResultEqualNegativOne) {
            score = "Advantage player2";
        } else if (isMinusResultOverOrEqualTwo) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }
}
