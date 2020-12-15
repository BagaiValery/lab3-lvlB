package table3;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
	
	private Double[] coefficients;
	private Double from;
	private Double to;
	private Double step;
	private Boolean fl;
	private Double result;
	
	public GornerTableModel(Double from, Double to, Double step, Double[]
			coefficients) {
			this.from = from;
			this.to = to;
			this.step = step;
			this.coefficients = coefficients;
			}
	
	public Double getFrom() {
		return from;
		}
		public Double getTo() {
		return to;
		}
		public Double getStep() {
		return step;
		}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		 if (columnIndex == 2) return Boolean.class;
		  else return Double.class; 
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
		return "Значение X";
		case 1:
		return "Значение многочлена";
		default:  
		return "Две пары";
		}
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getRowCount() {
		return new Double(Math.ceil((to-from)/step)).intValue()+1;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
		double x = from + step*row;
		switch (col) {
		case 0:
		return x;
		case 1:
		 {
	        result=0.0;

	        for(int i=0;i<coefficients.length;i++)
	        {
	            result+=Math.pow(x, coefficients.length-1-i)*coefficients[i];
	        }
	        return result;
		}
		default:
		{	
			fl = false;
			int schet=0;
			int cheslo2, cheslodrob2;
			double copy2=result;
			double copy = result;
			do
			{
				int cheslo=(int)(copy%10);
				
				copy=copy/10; 
				cheslo2=(int)(copy%10);
				if (cheslo==cheslo2)schet++;
				
				if(result*10!=0 && ((copy2*10)%10)!=0)
				{	int cheslodrob = (int)(result*10)%10;
				copy2=copy2*10;
				cheslodrob2=(int)(copy2%10);
				if (cheslodrob==cheslodrob2)schet++;
				}
				
				if(schet>=2) {fl=true; schet=0;}
			}while(cheslo2!=0);
			return fl;
		}
		}
		 

	}

}
