
public class MyList{
    ArrayList<Object> arr = new ArrayList<Object>(Arrays.asList());

    public ArrayList<Object> removeAll(Object a) {
        while(arr.remove(a))
            arr.remove(a);
        return arr;
    }

    @Before
    public void before() {
        MyList mylist = new MyList();
        if(arr.size()==0)
            fail("The array has no elements!");
    }

    @Test
    public void test(){
        System.out.println(arr);
        ArrayList<Object> arr2 = new ArrayList<Object>();
        arr2.add(2);
        arr2.add(3);

        assertEquals( true, arr2.equals(removeAll(1)));
    }

}