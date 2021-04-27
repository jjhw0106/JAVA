package atm_v3;

import java.io.IOException;

public interface UserRepository {
	public void save(User user);

	public User getUserByID(String id);

	public User getUserByIdx(int idx);

	public int getIdx(String id);

	public void update(int log, User user);

	public void delete(int log);

}
