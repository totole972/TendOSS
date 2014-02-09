package tendoss

class Answer {

	String content
	
    Date answerDate = new Date()

    static belongsTo = [author: User]
    static hasMany = [attachements: File, votes: Vote]

    static mapping = {
        version(false)
    }

    static constraints = {
		content blank: false
    }
}
