package ohtu;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    private static final int LOVE = 0;
    private static final int FIFTEEN = 1;
    private static final int THIRTY = 2;
    private static final int FORTY = 3;
    private static final int DEUCE = 4;
    private static final int ADVANTAGE_PLAYER1 = 1;
    private static final int ADVANTAGE_PLAYER2 = -1;
    private static final int WIN_PLAYER1 = 2;
    private static final int WIN_PLAYER2 = -2;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            m_score1 += 1;
        } else if (playerName.equals(player2Name)) {
            m_score2 += 1;
        }
    }

    public String getScore() {
        String scorePrint = "";
        if (m_score1 == m_score2) {
            scorePrint += this.scoresAsString(m_score1);
            if (m_score1 != DEUCE) {
                scorePrint += "-All";
            }
        } else if (m_score1 >= DEUCE || m_score2 >= DEUCE) {
            scorePrint += this.deuce();
        } else {
            scorePrint += this.otherCases();
        }
        return scorePrint;
    }

    private String scoresAsString(int score) {
        switch (score) {
            case LOVE:
                return "Love";
            case FIFTEEN:
                return "Fifteen";
            case THIRTY:
                return "Thirty";
            case FORTY:
                return "Forty";
            case DEUCE:
                return "Deuce";
            default:
                break;
        }
        return "";
    }

    private String deuce() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == ADVANTAGE_PLAYER1) {
            return "Advantage player1";
        } else if (minusResult == ADVANTAGE_PLAYER2) {
            return "Advantage player2";
        } else if (minusResult >= WIN_PLAYER1) {
            return "Win for player1";
        } else if (minusResult <= WIN_PLAYER2) {
            return "Win for player2";
        }
        return "";
    }

    private String otherCases() {
        int tempScore = 0;
        String scorePrint = "";
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = m_score1;
            } else {
                scorePrint += "-";
                tempScore = m_score2;
            }
            scorePrint += this.scoresAsString(tempScore);
        }
        return scorePrint;
    }
}
