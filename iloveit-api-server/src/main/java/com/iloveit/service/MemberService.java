import com.iloveit.entity.Member;
import org.springframework.stereotype.Service;
import com.iloveit.repository.MemberRepository;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long signup(Member member) {
        return memberRepository.save(member).getId();
    }
}
