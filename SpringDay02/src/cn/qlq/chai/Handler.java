package cn.qlq.chai;


/**
 * 
* @author: qlq
* @date :  2018年4月8日下午5:09:07
 */
public abstract class Handler {

    private Handler sucessor;

    public Handler getSucessor() {
        return sucessor;
    }

    public void setSucessor(Handler sucessor) {
        this.sucessor = sucessor;
    }

    public void execute(){
        handleProcess();
        if(sucessor != null){
            sucessor.execute();
        }
    }

    protected abstract void handleProcess();
}
