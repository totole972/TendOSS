package tendoss

class Tender {

    String name
    String description
	Date answerDeadline
	
    Date submissionDate = new Date()
	
    Boolean closed = false

    static belongsTo = [postOwner: User]
    static hasMany = [answers: Answer, attachements: File, requirements: TenderTechno, votes: Vote]

    static constraints = {
        name blank: false, unique: true, maxSize: 256
		description blank: false
		answerDeadline min: new Date() + 6
        votes nullable: true
    }

    static mapping = {
        version(false)
		description type: "text"
    }

	
	static transients = ['lightDescription']

    String getLightDescription() {
		description.take(127) + "..."
    }

    static Comparator getComparator() {
        def c =[
                compare: { a, b ->
                    def resa = a.votes?.sum()?:0
                    def resb = b.votes?.sum()?:0
                    def result = resa <=> resb
                    if( result == 0 ) {
                        result = a.name <=> b.name
                    }
                    return result
                }
        ] as Comparator
    }
}