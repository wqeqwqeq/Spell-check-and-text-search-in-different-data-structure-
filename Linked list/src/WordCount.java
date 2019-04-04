/*
class of word count to include both string and data in the node
 */
public class WordCount{
    /*
    this class will include both data and count, we set data and count as private
    and we included setter and getter
    and we included toString and compareTo method
    we then include method of equal
     */

    private String data;// private String data
    private  int count;// private count integer
    public WordCount (){this.data=" "; this.count=0; }
    public WordCount(String data){
        this.data=data;
    }
    public WordCount(int count){ this.count=count;}

    /*
    neccessary setter and getter method
     */
    public void setString(String data){ this.data=data;}
    public void setCount(int count){this.count=count;}
    public String getString(){return data;}
    public void countonce(){ count++;}
    public int getCount(){return count;}
    public String toString(){ return data+" "+count; }
    /*

    This method will pass a WordCount object and calculate the difference
    return difference as an integer
    @param WordCount wc
    return difference
     */
    public  int compareto(WordCount WC){
        int difference=0;
        difference=this.count-WC.count;
        return difference;

    }
    /*
     This method will pass a wordcount object and check if the parameter is equal
     this method will return a boolean value
     if they are equal return true, if not equal return false then
         @param WordCount wc
         return boolean
     */
    public boolean equal(WordCount WC){

        if (this.data.equals(WC.data)){return true;}
        else return  false;
    }


}