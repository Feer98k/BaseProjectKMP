import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class MatchesFootballResponseModel(
    @SerialName("matches") val matches: List<Match> // List of all matches in the round
)

@Serializable
data class Match(
    @SerialName("id") val id: String, // Unique match identifier
    @SerialName("lg") val league: String, // League name
    @SerialName("cl") val countryLeague: String, // Country where the league is played
    @SerialName("ht") val homeTeam: String, // Home team name
    @SerialName("at") val awayTeam: String, // Away team name
    @SerialName("st") val startTime: String, // Match start time in UTC (ISO8601)
    @SerialName("ss") val status: String, // Match status (e.g., "scheduled")
    @SerialName("pr") val probabilities: Probabilities, // Probabilities for win/draw/loss
    @SerialName("od") val odds: Odds, // AI-estimated odds
    @SerialName("mw") val matchWeight: String, // Popularity weight: "zero" to "three"
    @SerialName("ap") val additionalPredictions: AdditionalPredictions // Extended predictions
)

@Serializable
data class Probabilities(
    @SerialName("hw") val homeWin: Int, // % chance of home team win
    @SerialName("d") val draw: Int, // % chance of draw
    @SerialName("aw") val awayWin: Int // % chance of away team win
)

@Serializable
data class Odds(
    @SerialName("hw") val homeWin: Double, // Odds for home team win
    @SerialName("d") val draw: Double, // Odds for draw
    @SerialName("aw") val awayWin: Double // Odds for away team win
)

@Serializable
data class AdditionalPredictions(
    @SerialName("gp") val goals: GoalsProbability, // Goal-related predictions
    @SerialName("cp") val corners: CornersProbability, // Corner kick predictions
    @SerialName("cdp") val cards: CardsProbability, // Card predictions
    @SerialName("dc") val doubleChance: DoubleChance, // Double chance outcomes
    @SerialName("fts") val firstTeamToScore: FirstTeamToScore, // Who scores first
    @SerialName("fhr") val firstHalfResult: FirstHalfResult, // Predicted first-half result
    @SerialName("tgr") val totalGoalsRange: TotalGoalsRange, // Predicted goal count range
    @SerialName("tmc") val teamMostCards: TeamMostCards // Which team is likely to receive more cards
)

@Serializable
data class GoalsProbability(
    @SerialName("o25") val over2_5Goals: Int, // % chance of over 2.5 goals
    @SerialName("u25") val under2_5Goals: Int, // % chance of under 2.5 goals
    @SerialName("bts") val bothTeamsToScore: Int // % chance both teams score
)

@Serializable
data class CornersProbability(
    @SerialName("o95") val over9_5Corners: Int, // % chance of over 9.5 corners
    @SerialName("u95") val under9_5Corners: Int // % chance of under 9.5 corners
)

@Serializable
data class CardsProbability(
    @SerialName("tyc") val totalYellowCards: Int, // Predicted number of yellow cards
    @SerialName("trc") val totalRedCards: Int // Predicted number of red cards
)

@Serializable
data class DoubleChance(
    @SerialName("hod") val homeOrDraw: Int, // % chance of home win or draw
    @SerialName("aod") val awayOrDraw: Int, // % chance of away win or draw
    @SerialName("hoa") val homeOrAway: Int // % chance of home or away win (no draw)
)

@Serializable
data class FirstTeamToScore(
    @SerialName("h") val home: Int, // % chance home team scores first
    @SerialName("a") val away: Int, // % chance away team scores first
    @SerialName("n") val none: Int // % chance of no goals
)

@Serializable
data class FirstHalfResult(
    @SerialName("hw") val homeWin: Int, // % chance home wins first half
    @SerialName("d") val draw: Int, // % chance of draw in first half
    @SerialName("aw") val awayWin: Int // % chance away wins first half
)

@Serializable
data class TotalGoalsRange(
    @SerialName("zto") val zeroToOne: Int, // % chance of 0–1 goals
    @SerialName("ttt") val twoToThree: Int, // % chance of 2–3 goals
    @SerialName("fp") val fourPlus: Int // % chance of 4 or more goals
)

@Serializable
data class TeamMostCards(
    @SerialName("h") val home: Int, // % chance home team receives most cards
    @SerialName("a") val away: Int, // % chance away team receives most cards
    @SerialName("e") val equal: Int // % chance of equal cards
)