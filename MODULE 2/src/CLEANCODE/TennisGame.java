package CLEANCODE;

public class TennisGame {

    public static final String SCORE = "-";

    public static String getScore(String firstplayerName, String secondplayerName, int scoreFirstPlay, int scoreSecondPlay) {
        String score = "";
        int tempScore = 0;
        boolean isScore = scoreFirstPlay == scoreSecondPlay;
        if (isScore) {
            switch (scoreFirstPlay) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else {
            boolean isScoreFirstPlay = scoreFirstPlay >= 4;
            boolean isScoreSecondPlay = scoreSecondPlay >= 4;
            if (isScoreFirstPlay || isScoreSecondPlay) {
                score = getString(scoreFirstPlay, scoreSecondPlay);
            } else {
                for (int i = 1; i < 3; i++) {
                    if (i == 1) tempScore = scoreFirstPlay;
                    else {
                        score += SCORE;
                        tempScore = scoreSecondPlay;
                    }
                    switch (tempScore) {
                        case 0:
                            score += "Love";
                            break;
                        case 1:
                            score += "Fifteen";
                            break;
                        case 2:
                            score += "Thirty";
                            break;
                        case 3:
                            score += "Forty";
                            break;
                    }
                }
            }
        }
        return score;
    }

    private static String getString(int scoreFirstPlay, int scoreSecondPlay) {
        String score;
        int minusResult = scoreFirstPlay - scoreSecondPlay;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }
}
