package com.verticon.google.kmlgx.core.model.tests.extra;

import com.verticon.atom.authorlink.AtomRoot;
import com.verticon.atom.authorlink.Author;
import com.verticon.atom.authorlink.Link;
import com.verticon.atom.authorlink.util.AuthorlinkSwitch;

public class AuthorlinkDiagnosticVisitor extends AuthorlinkSwitch<Object>{

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Author visited ";
	}
	
	/* (non-Javadoc)
	 * @see com.verticon.atom.authorlink.util.AuthorlinkSwitch#caseAtomRoot(com.verticon.atom.authorlink.AtomRoot)
	 */
	@Override
	public Object caseAtomRoot(AtomRoot object) {
		System.out.println(this+" atomRoot: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.atom.authorlink.util.AuthorlinkSwitch#caseAuthor(com.verticon.atom.authorlink.Author)
	 */
	@Override
	public Object caseAuthor(Author object) {
		System.out.println(this+" author: " + object);
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.verticon.atom.authorlink.util.AuthorlinkSwitch#caseLink(com.verticon.atom.authorlink.Link)
	 */
	@Override
	public Object caseLink(Link object) {
		System.out.println(this+" link: " + object);
		return Boolean.TRUE;
	}
	

	
}
