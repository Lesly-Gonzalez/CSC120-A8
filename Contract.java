/*
@File       : Contract.java
@Time       : 2022/11/16 4:00 PM EST
@Author     : JCrouser edited by Lily G., Juniper H., Lesly H., and Priscilla T.
@Desc       : A Java file that contains the skeleton contract for our code. We did not have to make any edits to this file.
*/

public interface Contract {

    void grab(String item);

    String drop(String item);

    void examine(String item);

    void use(String item);

    boolean walk(String direction);

    boolean fly(int x, int y);
    
    Number shrink();

    Number grow();

    void rest();

    void undo();

}