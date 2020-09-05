package designerpattern.state.badCase;

public interface VoteState {
    /**
     * 状态的处理
     */
    public void vote(String user, String voteItem, VoteManager voteManager);

}
