package tendoss

class Tender {

    String name
    String lightDescription
    String detailedDescription
    Date submissionDate
    Date answerDeadline
    Date delivaryDeadline


    static belongsTo = [author: User]
    static hasMany = [answers: Answer, attachements: File, requirements: TenderTechno, participants: User]

    static constraints = {
        name nullable: false, blank:false
        submissionDate nullable: false, blank: false
    }

    static mapping = {
        version(false)
    }
}
