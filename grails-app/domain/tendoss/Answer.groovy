package tendoss

class Answer {

    Date answerDate
    String content



	// Test Cloudbees building automatically after a push.
    static belongsTo = [author: User]
    static hasMany = [attachements: File, answers: Answer, votes: Vote]

    static mapping = {
        version(false)
    }

    static constraints = {
        answerDate nullable: false, blank: false
        content nullable: false, blank: false
    }
}
