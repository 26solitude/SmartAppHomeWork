package kr.ac.kumoh.s20161163.myapplication

data class KpopMember(
    val MemberID : Int,
    val GroupName: String, // 수정: 그룹 이름은 문자열로 정의되어야 합니다.
    val DebutDate: String,
    val Company: String,
    val MemberName: String,
    val BirthDate: String,
    val Position: String,
    val FullBodyImageURL: String,
    val FaceImageURL: String,
)
