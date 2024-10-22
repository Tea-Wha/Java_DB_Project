import dao.EmpDAO;
import vo.EmpVO;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class JdbcMain {
    public static void main(String[] args) {
    menuSelect();

    }
    public static void menuSelect(){
        Scanner scanner = new Scanner(System.in);
        EmpDAO dao = new EmpDAO();
        boolean isSuccess;
        while (true){
            System.out.println("======= EMP TABLE =======");
            System.out.println("메뉴를 선택 하세요 : ");
            System.out.print("[1]SELECT [2]INSERT [3]UPDATE [4]DELETE [5]EXIT :");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    List<EmpVO> list = dao.empSelect();
                    dao.empSelectResult(list);
                    break;
                case 2:
                    isSuccess = dao.empInsert(empInput());
                    if (isSuccess) System.out.println("사원 등록에 성공했습니다.");
                    else System.out.println("사원 등록에 실패했습니다.");
                    break;
                case 3:
                    isSuccess = dao.empUpdate();
                    if (isSuccess) System.out.println("사원 수정에 성공했습니다.");
                    else System.out.println("사원 수정에 실패했습니다.");
                    break;
                case 4:
                    isSuccess = dao.empDelete();
                    if (isSuccess) System.out.println("사원 삭제에 성공했습니다.");
                    else System.out.println("사원 삭제에 실패했습니다.");
                    break;
                case 5:
                    System.out.println("프로그램을 종료 합니다.");
                    return;
            }
        }
    }
    public static EmpVO empInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("사원 정보 입력");
        System.out.print("사원 번호 : ");
        int empNo = scanner.nextInt();
        System.out.print("사원 이름 : ");
        String name = scanner.next();
        System.out.print("직책 : ");
        String job = scanner.next();
        System.out.print("상관 사원 번호 : ");
        int mgr = scanner.nextInt();
        System.out.print("입사일 : ");
        // 2024-10-22
        String date = scanner.next(); // 문자열로 입력 받아도 날짜 형식에 맞으면 입력 가능
        System.out.print("급여 : ");
        BigDecimal sal = scanner.nextBigDecimal();
        System.out.print("성과급 : ");
        BigDecimal comm = scanner.nextBigDecimal();
        System.out.print("부서 번호 : ");
        int deptNo = scanner.nextInt();
        EmpVO vo = new EmpVO(empNo, name, job, mgr, Date.valueOf(date), sal, comm, deptNo);
        return vo;
    }
}