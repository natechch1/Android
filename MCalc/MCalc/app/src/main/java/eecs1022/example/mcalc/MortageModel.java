package eecs1022.example.mcalc;

public class MortageModel
{
    private double principle;
    private int amortization;
    private double interest;

    private double result;

    public MortageModel(String p,String a,String i)
    {
        this.principle = Double.parseDouble(p);
        this.amortization = Integer.parseInt(a);
        this.interest = Double.parseDouble(i);
    }

    public String computePayment()
    {
        double interest = (this.interest)/(100*12);
        int amortization = this.amortization*12;
        result = (this.principle*interest)/(1-Math.pow(1+interest,-amortization));
        String output = String.format("%,.2f",result);
        return output;
    }

    public String outStandingafter()
    {
        double interest = (this.interest)/(100*12);
        double amortization = this.amortization*12;
        double result2 = (this.principle-((result/interest)-principle)/(Math.pow(1+interest,60)-1));
        String output = String.format("%,.0f",result2);
        return output;
    }

    public static void main(String[] args)
    {
        MortageModel myModel = new MortageModel("700000","25","2.75");
        System.out.println(myModel.computePayment());

        myModel = new MortageModel("300000","20","4.50");
        System.out.println(myModel.computePayment());


    }
}
