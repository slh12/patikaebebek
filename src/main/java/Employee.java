public class Employee {

    static String name;
    static int salary;
    static int workHours;
    static int hireYear;

    public Employee(int salary, int workHours, int hireYear, String name) { }



    public static int tax(int salary) {

        if (salary < 1000) {
            return 0;
        } else
            return (salary * 3) / 100;
    }



    public static int bonus(int workHours) {

        //Bonus hesaplarken 1 ayda 4 hafta olduğu için haftalık bonusu((workhours-40)*30)'u tekrar 4 ile çarpıyoruz.
        if (workHours > 40) {
            return ((workHours - 40)*30)*4;
        } else
            return 0;
    }



    public static int raiseSalary(int salary) {
        int workyear = 2021 - hireYear;
        int raiseAmount = 0;

        //Maaş artışı hesaplarken sadece vergi ve bonusun toplamına göre hesaplıyoruz.

        if (workyear < 10) {
            raiseAmount = ((salary+bonus(workHours)) * 5) / 100;
        } else if (workyear < 20) {
            raiseAmount = ((salary+bonus(workHours)) * 10) / 100;
        }
        else if (workyear>19){
            raiseAmount=((salary+bonus(workHours))*15)/100;
        }
        return raiseAmount;
    }




    public static void main(String[] args) {

        Employee worker = new Employee(salary=2000, workHours=45, hireYear=1985, name="kemal");

        System.out.println("Adı: " + name);
        System.out.println("Maaşı= " + salary);
        System.out.println("Çalışma saati: " + workHours);
        System.out.println("Başlangıç yılı: " + hireYear);

        System.out.println("Vergi: " + tax(salary));
        System.out.println("Bonus: " + bonus(workHours));
        System.out.println("Maaş artışı: "+ raiseSalary(salary));

        System.out.println("Toplam maaşı:" +(salary + bonus(workHours)+ raiseSalary(salary)));

        /*Case'de "vergi ve bonuslarla birlikete maaş: vergi, bonus ve çalışanın kendi maaşı ile bulunacak."
        yazdığı için maaş artışını dahil edilmedi. Dolayısıyla "(maaş+bonus)-vergi" şeklinde bir formül uygulamak
        gerekiyor.
         */

        System.out.println("Vergi ve bonuslarla birlikte maaş: " + ((salary + bonus(workHours)) - tax(salary)));

    }
}




