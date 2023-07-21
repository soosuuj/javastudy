package ex06_Member;

public class MainWrapper {

  public static void main(String[] args) {

    Address address = new Address();
   // 정보 추가 (setter 활용) 
    address.setPostCode("08505");
    address.setRoadAddr("가산디지털2로 95");
    address.setJibunAddr("가산동 550-7");
    address.setDetailAddr("3층 G강의실");
    
   
    Contact contact = new Contact();
    // 정보 추가 (setter 활용) 
    contact.setHomeTel("02-324-4567");
    contact.setMobile("010-1234-7890");
    contact.setAddress(address);
    
    
    Member member = new Member();
    // 정보 추가 (setter 활용) 
    member.setName("홍길동");
    member.setContact(contact);
    
    //  Member member 객체 정보 확인 (getter 활용)
   /*
    member.info();
    contact.info();
    address.info();
    */
    
    System.out.println("이름 : " + member.getName());
    System.out.println("집전화 : " + member.getContact().getHomeTel());
    System.out.println("모바일 : " + member.getContact().getMobile());
    System.out.println("우편번호 " + member.getContact().getAddress().getPostCode());
    System.out.println("도로명 : " + member.getContact().getAddress().getJibunAddr());
    System.out.println("상세주소 : " + member.getContact().getAddress().getDetailAddr());
  }

}
