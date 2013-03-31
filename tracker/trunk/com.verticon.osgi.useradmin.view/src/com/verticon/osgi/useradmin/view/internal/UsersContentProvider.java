package com.verticon.osgi.useradmin.view.internal;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.useradmin.Group;
import org.osgi.service.useradmin.Role;
import org.osgi.service.useradmin.UserAdmin;

public class UsersContentProvider implements ITreeContentProvider {

	final Map<String, PropertiesNode[]> nodesCache = newHashMap();

	public static class PropertiesNode {
		public static final int MEMBERS = 0;
		public static final int REQUIRED_MEMBERS = 1;
		private final Group parent;
		private final int type;

		public PropertiesNode(int type, Group parent) {
			this.parent = parent;
			this.type = type;
		}

		public Group getParent() {
			return parent;
		}

		public Role[] getChildren() {
			if (type == MEMBERS) {
				return parent.getMembers();
			} else {
				return parent.getRequiredMembers();
			}
		}

		public int getType() {
			return type;
		}
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Group) {
			Group group = (Group) parentElement;
			if (nodesCache.containsKey(group.getName())) {
				return nodesCache.get(group.getName());
			}

			PropertiesNode[] nodes = new PropertiesNode[] {
					new PropertiesNode(PropertiesNode.MEMBERS, group),
					new PropertiesNode(PropertiesNode.REQUIRED_MEMBERS, group) };
			nodesCache.put(group.getName(), nodes);
			return nodes;

		} else if (parentElement instanceof PropertiesNode) {
			PropertiesNode node = (PropertiesNode) parentElement;

			Role[] children = node.getChildren();

			if (children != null) {
				return children;
			}
		}
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Activator) {
			UserAdmin userAdmin = ((Activator) inputElement).getUserAdmin();
			return getRoles(userAdmin);
		}

		return new Object[0];
	}

	Object[] getRoles(UserAdmin userAdmin) {
		if (userAdmin != null) {
			// Authorization auth = userAdmin.getAuthorization(user);
			if (Activator.getDefault().isUserAdmininistrator()) {
				try {
					return userAdmin.getRoles(null);
				} catch (InvalidSyntaxException e) {
					// empty
				}
			}
		}
		return new Object[0];
	}

	@Override
	public void dispose() {
		nodesCache.clear();
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// empty
	}

}
