package com.korit.study.ch17;

public class PrincipalAuthentication extends AbstractAuthentication {

    // AbstractAuthentication에 아무것도 없는 생성자가 없기 때문에 여기서 매개변수를 지정해주어야 오류가 없음
    // AbstractAuthentication에 아무것도 없는 생성자를 생성하면 만들어 주지 않아도 괜찮음
    public PrincipalAuthentication(User user) {
        super(user);
    }

    public boolean containsAuthority(String role) {
        for (GrantedAuthority authority : getAuthorities()) {

            if (authority.getAuthority().equalsIgnoreCase(role)){
                return true;
            }

            if (authority.getAuthority().replaceAll("ROLE_", "").equalsIgnoreCase(role)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void checkAuthority() {
        System.out.print("권한: [");
        for (GrantedAuthority authority : getAuthorities()) {
            System.out.print(authority.getAuthority() + " ");
        }
        System.out.println("]");
    }

    @Override
    public String getUsername() {
        return super.getUser().getUsername();
    }

    @Override
    public String getPassword() {
        return super.getUser().getPassword();
    }

    @Override
    public GrantedAuthority[] getAuthorities() {
        GrantedAuthority[] authorities = new GrantedAuthority[super.getUser().getRoles().length];
        for (int i = 0; i < super.getUser().getRoles().length; i++) {
            authorities[i] = new SimpleGrantedAuthority(super.getUser().getRoles()[i]);
        }
        return authorities;
    }
}
