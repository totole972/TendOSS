package tendoss

class Tender {

    String name
    String description
	Date answerDeadline
	
    Date submissionDate = new Date()
	
    Boolean closed = false

    static belongsTo = [User]
    static hasMany = [answers: Answer, attachements: File, requirements: TenderTechno, participants: User]

    static constraints = {
        name blank: false, unique: true, maxSize: 256
		description blank: false
		answerDeadline min: new Date() + 6
    }

    static mapping = {
        version(false)
		description type: "text"
    }

	
	static transients = ['lightDescription']

    String getLightDescription() {
		description.take(127) + "..."
    }
}
